package com.brand.blockus.blocks.Base.RequiredTool;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;

public class PillarBaseRT extends PillarBlock {
	
	public PillarBaseRT(String name, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel, MaterialColor color) {
		super(FabricBlockSettings.of(material, color).sounds(sound).requiresTool().breakByTool(tag, mininglevel).strength(hardness, resistance));
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
	}

}
