package net.dawnsinfire.uteb;

import net.dawnsinfire.uteb.blocks.ModBlocks;
import net.dawnsinfire.uteb.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(UnlockTheEndBackport.MODID)
public class UnlockTheEndBackport {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "unlocktheendbackport";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public UnlockTheEndBackport(IEventBus modEventBus, ModContainer modContainer) {

        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ModItems.ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (UnlockTheEndBackport) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }


    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.WARDEN_KEY);
            event.accept(ModItems.BASTION_KEY);
            event.accept(ModItems.ILLAGER_KEY);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.WARDEN_LOCK_SIDE.asItem());
            event.accept(ModBlocks.WARDEN_LOCK_MIDDLE.asItem());
            event.accept(ModBlocks.BASTION_LOCK_SIDE.asItem());
            event.accept(ModBlocks.BASTION_LOCK_MIDDLE.asItem());
            event.accept(ModBlocks.ILLAGER_LOCK_SIDE.asItem());
            event.accept(ModBlocks.ILLAGER_LOCK_MIDDLE.asItem());
            event.accept(ModBlocks.TRIAL_LOCK_SIDE.asItem());
            event.accept(ModBlocks.TRIAL_LOCK_MIDDLE.asItem());
        }
    }




    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
