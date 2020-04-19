package com.fractava.fabricmc.half_a_heart;

import com.fractava.fabricmc.half_a_heart.item.HealthCatalystItem;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HalfAHeart implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "half-a-heart";
    public static final String MOD_NAME = "half-a-heart";

    public static final Item HEALTH_CATALYST_ITEM = new HealthCatalystItem(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fabric_item"), HEALTH_CATALYST_ITEM);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}