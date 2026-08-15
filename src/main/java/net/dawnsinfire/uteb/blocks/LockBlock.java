package net.dawnsinfire.uteb.blocks;

import com.mojang.serialization.MapCodec;
import net.dawnsinfire.uteb.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class LockBlock extends HorizontalDirectionalBlock {

    public LockBlock(Properties properties) {
        super(properties);
    }

    public static final MapCodec<LockBlock> CODEC = simpleCodec(LockBlock::new);

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {

        return Shapes.box(0,0,0,1,0.8125f,1);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ArrayList<BlockPos> Poses = new ArrayList<>();
        Poses.add(0, pos.offset(1,0,0));
        Poses.add(1,pos.offset(0,0,1));
        Poses.add(2,pos.offset(-1,0,0));
        Poses.add(3,pos.offset(0,0,-1));

        if (stack.is(ModItems.WARDEN_KEY) && state.getBlock().equals((ModBlocks.WARDEN_LOCK_MIDDLE).get())) {
            if (!level.isClientSide()) {
                if (!player.hasInfiniteMaterials()) {
                    stack.shrink(1);
                }
                Direction BlockFacing = state.getValue(FACING);
                for (int x = 0; x < 4; x++) {
                    if (level.getBlockState(Poses.get(x)).is(ModBlocks.WARDEN_LOCK_SIDE)) {
                        level.setBlock(Poses.get(x), Blocks.END_PORTAL_FRAME.defaultBlockState()
                                .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
                    }
                }
                level.setBlock(pos, Blocks.END_PORTAL_FRAME.defaultBlockState()
                        .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);

        }
        else if (stack.is(ModItems.ILLAGER_KEY) && state.getBlock().equals((ModBlocks.ILLAGER_LOCK_MIDDLE).get())  && !level.isClientSide()) {
            if (!player.hasInfiniteMaterials()) {
                stack.shrink(1);
            }
            Direction BlockFacing =  state.getValue(FACING);
            for (int x = 0; x <4; x++) {
                if (level.getBlockState(Poses.get(x)).is(ModBlocks.ILLAGER_LOCK_SIDE)) {
                    level.setBlock(Poses.get(x), Blocks.END_PORTAL_FRAME.defaultBlockState()
                            .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
                }
            }
            level.setBlock(pos, Blocks.END_PORTAL_FRAME.defaultBlockState()
                    .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
            return ItemInteractionResult.SUCCESS;
        }
        else if (stack.is(Items.OMINOUS_TRIAL_KEY) && state.getBlock().equals((ModBlocks.TRIAL_LOCK_MIDDLE).get()) && !level.isClientSide()) {
            if (!player.hasInfiniteMaterials()) {
                stack.shrink(1);
            }
            Direction BlockFacing =  state.getValue(FACING);
            for (int x = 0; x <4; x++) {
                if (level.getBlockState(Poses.get(x)).is(ModBlocks.TRIAL_LOCK_SIDE)) {
                    level.setBlock(Poses.get(x), Blocks.END_PORTAL_FRAME.defaultBlockState()
                            .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
                }
            }
            level.setBlock(pos, Blocks.END_PORTAL_FRAME.defaultBlockState()
                    .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
            return ItemInteractionResult.SUCCESS;
        }
        else if (stack.is(ModItems.BASTION_KEY) && state.getBlock().equals((ModBlocks.BASTION_LOCK_MIDDLE).get()) && !level.isClientSide()) {
            if (!player.hasInfiniteMaterials()) {
                stack.shrink(1);
            }
            Direction BlockFacing =  state.getValue(FACING);
            for (int x = 0; x <4; x++) {
                if (level.getBlockState(Poses.get(x)).is(ModBlocks.BASTION_LOCK_SIDE)) {
                    level.setBlock(Poses.get(x), Blocks.END_PORTAL_FRAME.defaultBlockState()
                            .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
                }
            }
            level.setBlock(pos, Blocks.END_PORTAL_FRAME.defaultBlockState()
                    .setValue(EndPortalFrameBlock.FACING, BlockFacing), 3);
            return ItemInteractionResult.SUCCESS;
        }
        else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    

}
