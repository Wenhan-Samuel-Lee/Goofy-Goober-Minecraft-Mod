package com.wenhanlee.goofygoober;

import com.mojang.logging.LogUtils;
import com.wenhanlee.goofygoober.effects.ModEffects;
import com.wenhanlee.goofygoober.items.ModItems;
import com.wenhanlee.goofygoober.sounds.ModSounds;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GoofyGoober.MOD_ID)
public class GoofyGoober {
    public static final String MOD_ID = "goofygoober";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GoofyGoober() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModSounds.register(eventBus);
        ModEffects.register(eventBus);

        // Register the setup method for modloading
        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
