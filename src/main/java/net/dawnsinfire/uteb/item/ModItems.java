package net.dawnsinfire.uteb.item;

import net.dawnsinfire.uteb.UnlockTheEndBackport;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UnlockTheEndBackport.MODID);

    public static final DeferredItem<Item> WARDEN_KEY = ITEMS.registerItem(
            "warden_key",
            Item::new,
            new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)

    );
    public static final DeferredItem<Item> BASTION_KEY = ITEMS.registerItem(
            "bastion_key",
            Item::new,
            new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)
    );
    public static final DeferredItem<Item> ILLAGER_KEY = ITEMS.registerItem(
            "illager_key",
            Item::new,
            new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


