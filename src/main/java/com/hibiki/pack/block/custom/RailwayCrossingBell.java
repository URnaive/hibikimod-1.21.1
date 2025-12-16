package com.hibiki.pack.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

public class RailwayCrossingBell extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(7, 0, 7, 9, 32, 9),
            Block.createCuboidShape(4, 24, 6, 15, 26, 7),
            Block.createCuboidShape(2.5, 25, 6.5, 13.5, 27, 7.5),
            Block.createCuboidShape(11, 18, 5, 13, 20, 6),
            Block.createCuboidShape(2, 18, 5, 3, 20, 6),
            Block.createCuboidShape(2, 19, 4, 3, 20, 5),
            Block.createCuboidShape(5, 19, 4, 6, 20, 5),
            Block.createCuboidShape(6, 14, 5, 7, 16, 6),
            Block.createCuboidShape(6, 15, 4, 7, 16, 5),
            Block.createCuboidShape(9, 15, 4, 10, 16, 5),
            Block.createCuboidShape(9, 14, 5, 10, 16, 6),
            Block.createCuboidShape(7, 13, 5, 9, 14, 6),
            Block.createCuboidShape(7, 16, 4, 9, 17, 6),
            Block.createCuboidShape(7, 14, 5, 9, 16, 6),
            Block.createCuboidShape(5, 18, 5, 6, 20, 6),
            Block.createCuboidShape(3, 17, 5, 5, 18, 6),
            Block.createCuboidShape(3, 20, 4, 5, 21, 6),
            Block.createCuboidShape(3, 18, 5, 5, 20, 6),
            Block.createCuboidShape(11, 20, 4, 13, 21, 6),
            Block.createCuboidShape(11, 17, 5, 13, 18, 6),
            Block.createCuboidShape(13, 18, 5, 14, 20, 6),
            Block.createCuboidShape(13, 19, 4, 14, 20, 5),
            Block.createCuboidShape(10, 19, 4, 11, 20, 5),
            Block.createCuboidShape(10, 18, 5, 11, 20, 6),
            Block.createCuboidShape(5, 18, 6, 11, 19, 7),
            Block.createCuboidShape(4, 16, 6, 12, 17, 7),
            Block.createCuboidShape(3, 9, 6, 13, 12, 7),
            Block.createCuboidShape(6, 30, 4, 10, 32, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    public static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(7, 0, 7, 9, 32, 9),
            Block.createCuboidShape(1, 24, 9, 12, 26, 10),
            Block.createCuboidShape(2.5, 25, 8.5, 13.5, 27, 9.5),
            Block.createCuboidShape(3, 18, 10, 5, 20, 11),
            Block.createCuboidShape(13, 18, 10, 14, 20, 11),
            Block.createCuboidShape(13, 19, 11, 14, 20, 12),
            Block.createCuboidShape(10, 19, 11, 11, 20, 12),
            Block.createCuboidShape(9, 14, 10, 10, 16, 11),
            Block.createCuboidShape(9, 15, 11, 10, 16, 12),
            Block.createCuboidShape(6, 15, 11, 7, 16, 12),
            Block.createCuboidShape(6, 14, 10, 7, 16, 11),
            Block.createCuboidShape(7, 13, 10, 9, 14, 11),
            Block.createCuboidShape(7, 16, 10, 9, 17, 12),
            Block.createCuboidShape(7, 14, 10, 9, 16, 11),
            Block.createCuboidShape(10, 18, 10, 11, 20, 11),
            Block.createCuboidShape(11, 17, 10, 13, 18, 11),
            Block.createCuboidShape(11, 20, 10, 13, 21, 12),
            Block.createCuboidShape(11, 18, 10, 13, 20, 11),
            Block.createCuboidShape(3, 20, 10, 5, 21, 12),
            Block.createCuboidShape(3, 17, 10, 5, 18, 11),
            Block.createCuboidShape(2, 18, 10, 3, 20, 11),
            Block.createCuboidShape(2, 19, 11, 3, 20, 12),
            Block.createCuboidShape(5, 19, 11, 6, 20, 12),
            Block.createCuboidShape(5, 18, 10, 6, 20, 11),
            Block.createCuboidShape(5, 18, 9, 11, 19, 10),
            Block.createCuboidShape(4, 16, 9, 12, 17, 10),
            Block.createCuboidShape(3, 9, 9, 13, 12, 10),
            Block.createCuboidShape(6, 30, 9, 10, 32, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    public static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(7, 0, 7, 9, 32, 9),
            Block.createCuboidShape(9, 24, 4, 10, 26, 15),
            Block.createCuboidShape(8.5, 25, 2.5, 9.5, 27, 13.5),
            Block.createCuboidShape(10, 18, 11, 11, 20, 13),
            Block.createCuboidShape(10, 18, 2, 11, 20, 3),
            Block.createCuboidShape(11, 19, 2, 12, 20, 3),
            Block.createCuboidShape(11, 19, 5, 12, 20, 6),
            Block.createCuboidShape(10, 14, 6, 11, 16, 7),
            Block.createCuboidShape(11, 15, 6, 12, 16, 7),
            Block.createCuboidShape(11, 15, 9, 12, 16, 10),
            Block.createCuboidShape(10, 14, 9, 11, 16, 10),
            Block.createCuboidShape(10, 13, 7, 11, 14, 9),
            Block.createCuboidShape(10, 16, 7, 12, 17, 9),
            Block.createCuboidShape(10, 14, 7, 11, 16, 9),
            Block.createCuboidShape(10, 18, 5, 11, 20, 6),
            Block.createCuboidShape(10, 17, 3, 11, 18, 5),
            Block.createCuboidShape(10, 20, 3, 12, 21, 5),
            Block.createCuboidShape(10, 18, 3, 11, 20, 5),
            Block.createCuboidShape(10, 20, 11, 12, 21, 13),
            Block.createCuboidShape(10, 17, 11, 11, 18, 13),
            Block.createCuboidShape(10, 18, 13, 11, 20, 14),
            Block.createCuboidShape(11, 19, 13, 12, 20, 14),
            Block.createCuboidShape(11, 19, 10, 12, 20, 11),
            Block.createCuboidShape(10, 18, 10, 11, 20, 11),
            Block.createCuboidShape(9, 18, 5, 10, 19, 11),
            Block.createCuboidShape(9, 16, 4, 10, 17, 12),
            Block.createCuboidShape(9, 9, 3, 10, 12, 13),
            Block.createCuboidShape(9, 30, 6, 12, 32, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    public static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(7, 0, 7, 9, 32, 9),
            Block.createCuboidShape(6, 24, 1, 7, 26, 12),
            Block.createCuboidShape(6.5, 25, 2.5, 7.5, 27, 13.5),
            Block.createCuboidShape(5, 18, 3, 6, 20, 5),
            Block.createCuboidShape(5, 18, 13, 6, 20, 14),
            Block.createCuboidShape(4, 19, 13, 5, 20, 14),
            Block.createCuboidShape(4, 19, 10, 5, 20, 11),
            Block.createCuboidShape(5, 14, 9, 6, 16, 10),
            Block.createCuboidShape(4, 15, 9, 5, 16, 10),
            Block.createCuboidShape(4, 15, 6, 5, 16, 7),
            Block.createCuboidShape(5, 14, 6, 6, 16, 7),
            Block.createCuboidShape(5, 13, 7, 6, 14, 9),
            Block.createCuboidShape(4, 16, 7, 6, 17, 9),
            Block.createCuboidShape(5, 14, 7, 6, 16, 9),
            Block.createCuboidShape(5, 18, 10, 6, 20, 11),
            Block.createCuboidShape(5, 17, 11, 6, 18, 13),
            Block.createCuboidShape(4, 20, 11, 6, 21, 13),
            Block.createCuboidShape(5, 18, 11, 6, 20, 13),
            Block.createCuboidShape(4, 20, 3, 6, 21, 5),
            Block.createCuboidShape(5, 17, 3, 6, 18, 5),
            Block.createCuboidShape(5, 18, 2, 6, 20, 3),
            Block.createCuboidShape(4, 19, 2, 5, 20, 3),
            Block.createCuboidShape(4, 19, 5, 5, 20, 6),
            Block.createCuboidShape(5, 18, 5, 6, 20, 6),
            Block.createCuboidShape(6, 18, 5, 7, 19, 11),
            Block.createCuboidShape(6, 16, 4, 7, 17, 12),
            Block.createCuboidShape(6, 9, 3, 7, 12, 13),
            Block.createCuboidShape(4, 30, 6, 7, 32, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    public RailwayCrossingBell(Settings settings) {
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
