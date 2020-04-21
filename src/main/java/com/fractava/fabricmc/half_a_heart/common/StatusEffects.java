/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.fractava.fabricmc.half_a_heart.common;

import com.fractava.fabricmc.half_a_heart.HalfAHeart;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StatusEffects {
    public static final StatusEffect ATTRITION;
    private static StatusEffect registerEffect(Identifier id, StatusEffect entry) {
        return Registry.register(Registry.STATUS_EFFECT, id, entry);
    }

    static {
        ATTRITION = (StatusEffect) (new StatusEffect(StatusEffectType.HARMFUL, 8171462))
                        .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                                "a190115b-b394-445a-9a8d-bbdd8d0363db",
                                -0.1,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public static void init() {
        registerEffect(HalfAHeart.id("attrition"), ATTRITION);
    }

}
