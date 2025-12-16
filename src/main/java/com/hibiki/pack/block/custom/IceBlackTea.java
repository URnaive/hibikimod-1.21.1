package com.hibiki.pack.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class IceBlackTea extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_S =
            Stream.of(
            Block.createCuboidShape(4, 0, 5, 12, 1, 11),
            Block.createCuboidShape(4, 1, 5, 12, 9, 11),
            Block.createCuboidShape(4, 9, 5, 12, 10, 11),
            Block.createCuboidShape(5, 10, 6, 11, 11, 10),
            Block.createCuboidShape(6, 11, 7, 10, 12, 9),
            Block.createCuboidShape(7, 12, 7, 9, 14, 9),
            Block.createCuboidShape(3, 1, 5, 4, 9, 11),
            Block.createCuboidShape(12, 1, 5, 13, 9, 11),
            Block.createCuboidShape(4, 1, 4, 12, 9, 5),
            Block.createCuboidShape(4, 1, 11, 12, 9, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_N =
            Stream.of(
                    Block.createCuboidShape(4, 0, 5, 12, 1, 11),
                    Block.createCuboidShape(4, 1, 5, 12, 9, 11),
                    Block.createCuboidShape(4, 9, 5, 12, 10, 11),
                    Block.createCuboidShape(5, 10, 6, 11, 11, 10),
                    Block.createCuboidShape(6, 11, 7, 10, 12, 9),
                    Block.createCuboidShape(7, 12, 7, 9, 14, 9),
                    Block.createCuboidShape(12, 1, 5, 13, 9, 11),
                    Block.createCuboidShape(3, 1, 5, 4, 9, 11),
                    Block.createCuboidShape(4, 1, 11, 12, 9, 12),
                    Block.createCuboidShape(4, 1, 4, 12, 9, 5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_W =
            Stream.of(
                    Block.createCuboidShape(5, 0, 4, 11, 1, 12),
                    Block.createCuboidShape(5, 1, 4, 11, 9, 12),
                    Block.createCuboidShape(5, 9, 4, 11, 10, 12),
                    Block.createCuboidShape(6, 10, 5, 10, 11, 11),
                    Block.createCuboidShape(7, 11, 6, 9, 12, 10),
                    Block.createCuboidShape(7, 12, 7, 9, 14, 9),
                    Block.createCuboidShape(5, 1, 3, 11, 9, 4),
                    Block.createCuboidShape(5, 1, 12, 11, 9, 13),
                    Block.createCuboidShape(11, 1, 4, 12, 9, 12),
                    Block.createCuboidShape(4, 1, 4, 5, 9, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_E =
            Stream.of(
                    Block.createCuboidShape(5, 0, 4, 11, 1, 12),
                    Block.createCuboidShape(5, 1, 4, 11, 9, 12),
                    Block.createCuboidShape(5, 9, 4, 11, 10, 12),
                    Block.createCuboidShape(6, 10, 5, 10, 11, 11),
                    Block.createCuboidShape(7, 11, 6, 9, 12, 10),
                    Block.createCuboidShape(7, 12, 7, 9, 14, 9),
                    Block.createCuboidShape(5, 1, 12, 11, 9, 13),
                    Block.createCuboidShape(5, 1, 3, 11, 9, 4),
                    Block.createCuboidShape(4, 1, 4, 5, 9, 12),
                    Block.createCuboidShape(11, 1, 4, 12, 9, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public IceBlackTea(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)){
            case NORTH -> SHAPE_N;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            case EAST -> SHAPE_E;
            default ->  SHAPE_N;
        };
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING,ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
