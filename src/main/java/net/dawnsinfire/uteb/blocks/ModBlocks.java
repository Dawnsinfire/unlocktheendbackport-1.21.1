package net.dawnsinfire.uteb.blocks;

import net.dawnsinfire.uteb.UnlockTheEndBackport;
import net.dawnsinfire.uteb.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.concurrent.locks.Lock;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(UnlockTheEndBackport.MODID);
    //BLOCKS is a DeferredRegister.Blocks

    public static final DeferredBlock<LockBlock> WARDEN_LOCK_MIDDLE = BLOCKS.register(
            "warden_lock_middle",
            () -> new LockBlock(BlockBehaviour.Properties.of()
                    .strength(-1.0f, 100000.0f)));
    public static final DeferredItem<BlockItem> WARDEN_LOCK_MIDDLE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
         "warden_lock_middle", WARDEN_LOCK_MIDDLE
    );


    public static final DeferredBlock<LockBlock> WARDEN_LOCK_SIDE = BLOCKS.register(
            "warden_lock_side",
            () -> new LockBlock(BlockBehaviour.Properties.of()
                    .strength(-1.0f, 100000.0f)));

    public static final DeferredItem<BlockItem> WARDEN_LOCK_SIDE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
            "warden_lock_side", WARDEN_LOCK_SIDE
    );





    public static final DeferredBlock<LockBlock> BASTION_LOCK_MIDDLE = BLOCKS.register(
            "bastion_lock_middle",
            () -> new LockBlock(BlockBehaviour.Properties.of()
                    .strength(-1.0f, 100000.0f)));
    public static final DeferredItem<BlockItem> BASTION_LOCK_MIDDLE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
            "bastion_lock_middle", BASTION_LOCK_MIDDLE
    );





    public static final DeferredBlock<LockBlock> BASTION_LOCK_SIDE = BLOCKS.register(
            "bastion_lock_side",
            () -> new LockBlock(BlockBehaviour.Properties.of()
                    .strength(-1.0f, 100000.0f)));
    public static final DeferredItem<BlockItem> BASTION_LOCK_SIDE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
            "bastion_lock_side", BASTION_LOCK_SIDE
    );





    public static final DeferredBlock<LockBlock> ILLAGER_LOCK_MIDDLE = BLOCKS.register(
            "illager_lock_middle",
            () -> new LockBlock(BlockBehaviour.Properties.of()
                    .strength(-1.0f, 100000.0f)));
    public static final DeferredItem<BlockItem> ILLAGER_LOCK_MIDDLE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
            "illager_lock_middle", ILLAGER_LOCK_MIDDLE
    );



    public static final DeferredBlock<LockBlock> ILLAGER_LOCK_SIDE = BLOCKS.register(
            "illager_lock_side",
            () -> new LockBlock(BlockBehaviour.Properties.of()
                    .strength(-1.0f, 100000.0f)));
    public static final DeferredItem<BlockItem> ILLAGER_LOCK_SIDE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
            "illager_lock_side", ILLAGER_LOCK_SIDE
    );




  public static final DeferredBlock<LockBlock> TRIAL_LOCK_MIDDLE = BLOCKS.register(
          "trial_lock_middle",
          () -> new LockBlock(BlockBehaviour.Properties.of()
                  .strength(-1.0f, 100000.0f)));
    public static final DeferredItem<BlockItem> TRIAL_LOCK_MIDDLE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
            "trial_lock_middle", TRIAL_LOCK_MIDDLE
    );




  public static final DeferredBlock<LockBlock> TRIAL_LOCK_SIDE = BLOCKS.register(
          "trial_lock_side",
          () -> new LockBlock(BlockBehaviour.Properties.of()
                  .strength(-1.0f, 100000.0f)));
    public static final DeferredItem<BlockItem> TRIAL_LOCK_SIDE_ITEM = ModItems.ITEMS.registerSimpleBlockItem(
            "trial_lock_side", TRIAL_LOCK_SIDE
    );

}
