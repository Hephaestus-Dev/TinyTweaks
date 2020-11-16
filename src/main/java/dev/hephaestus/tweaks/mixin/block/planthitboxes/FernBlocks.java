package dev.hephaestus.tweaks.mixin.block.planthitboxes;

import dev.hephaestus.tweaks.Tweaks;
import dev.hephaestus.tweaks.util.ItemEntityShapeContext;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FernBlock.class)
public class FernBlocks extends PlantBlock {
    @Shadow @Final protected static VoxelShape SHAPE;

    protected FernBlocks(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        if (!Tweaks.CONFIG.plantHitboxes && !(context instanceof ItemEntityShapeContext && ((ItemEntityShapeContext) context).getItem().isIn(Tweaks.SHOWS_GRASS_HITBOXES))) {
            return VoxelShapes.empty();
        } else {
            return SHAPE;
        }
    }
}
