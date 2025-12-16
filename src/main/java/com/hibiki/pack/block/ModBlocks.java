package com.hibiki.pack.block;

import com.hibiki.pack.HibikiMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ICE_BLACK_TEA = register("ice_black_tea",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F).luminance(state -> 15).nonOpaque()));
    public static final Block MANEKI_NEKO = register("maneki_neko",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F).luminance(state -> 15).nonOpaque()));
    public static final Block YELLOEW_FLOOR_TILE = register("yellow_floor_tile",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F)));
    public static final Block KIM_IL_SUNG_PORTRAITBLOCK = register("kim_il_sung_portraitblock",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F).luminance(state -> 15)));
    public static final Block KIM_JUNG_IL_PORTRAITBLOCK = register("kim_jung_il_portraitblock",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F).luminance(state -> 15)));
    public static void registerBlockItems(String id, Block block){
        Item item = Registry.register(Registries.ITEM, Identifier.of(HibikiMod.MOD_ID, id),
                new BlockItem(block, new Item.Settings()));
        if(item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }
    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(HibikiMod.MOD_ID, id), block);
    }

    public static void registerModBlocks(){
        HibikiMod.LOGGER.info("Registering mod blocks");
    }
}
