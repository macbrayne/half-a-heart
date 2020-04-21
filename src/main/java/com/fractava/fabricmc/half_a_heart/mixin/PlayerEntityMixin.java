/*
 * Copyright (c) 2020 FRACTAVA GbR
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fractava.fabricmc.half_a_heart.mixin;

import com.fractava.fabricmc.half_a_heart.common.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerManager.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "respawnPlayer", at = @At(value = "RETURN"))
    public void applyAttritionEffect(ServerPlayerEntity player, boolean bl, CallbackInfoReturnable<ServerPlayerEntity> returnable) {
        int duration = 500;
        int amplifier = 0;
        ServerPlayerEntity serverPlayerEntity = returnable.getReturnValue();

        StatusEffectInstance currentInstance = player.getActiveStatusEffects().get(StatusEffects.ATTRITION);
        if(currentInstance != null) {
            int currentInstanceDuration = currentInstance.getDuration();
            int currentInstanceAmplifier = currentInstance.getAmplifier();

            serverPlayerEntity.removeStatusEffect(StatusEffects.ATTRITION);
            amplifier = currentInstanceAmplifier;
            duration += currentInstanceDuration;

            currentInstance.upgrade((new StatusEffectInstance(StatusEffects.ATTRITION, currentInstanceDuration, amplifier + 1)));
            currentInstance.upgrade(new StatusEffectInstance(StatusEffects.ATTRITION, duration, amplifier));
            serverPlayerEntity.addStatusEffect(currentInstance);
        } else {
            serverPlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ATTRITION, duration, amplifier));
        }

    }
}
