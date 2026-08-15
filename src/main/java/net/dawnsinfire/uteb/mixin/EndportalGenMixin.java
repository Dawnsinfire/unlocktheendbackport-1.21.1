package net.dawnsinfire.uteb.mixin;

import net.dawnsinfire.uteb.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdPieces;
import net.neoforged.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;


@Mixin(StrongholdPieces.PortalRoom.class)
public abstract class EndportalGenMixin extends StructurePiece {

    protected EndportalGenMixin(StructurePieceType type, int genDepth, BoundingBox boundingBox) {
        super(type, genDepth, boundingBox);
    }

    @Inject(method = "postProcess", at = @At("TAIL"))
    private void changeFrame(WorldGenLevel level, StructureManager structureManager, ChunkGenerator generator, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos pos, CallbackInfo ci) {
        this.placeBlock(level, ModBlocks.BASTION_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), 4, 3, 8, box);
        this.placeBlock(level, ModBlocks.BASTION_LOCK_MIDDLE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), 5, 3, 8, box);
        this.placeBlock(level, ModBlocks.BASTION_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), 6, 3, 8, box);

        this.placeBlock(level, ModBlocks.WARDEN_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), 4, 3, 12, box);
        this.placeBlock(level, ModBlocks.WARDEN_LOCK_MIDDLE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), 5, 3, 12, box);
        this.placeBlock(level, ModBlocks.WARDEN_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), 6, 3, 12, box);

        this.placeBlock(level, ModBlocks.TRIAL_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), 3, 3, 9, box);
        this.placeBlock(level, ModBlocks.TRIAL_LOCK_MIDDLE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), 3, 3, 10, box);
        this.placeBlock(level, ModBlocks.TRIAL_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), 3, 3, 11, box);

        this.placeBlock(level, ModBlocks.ILLAGER_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), 7, 3, 9, box);
        this.placeBlock(level, ModBlocks.ILLAGER_LOCK_MIDDLE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), 7, 3, 10, box);
        this.placeBlock(level, ModBlocks.ILLAGER_LOCK_SIDE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), 7, 3, 11, box);
    }
}
