package com.brand.blockus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brand.blockus.content.Asphalt;
import com.brand.blockus.content.Barrels;
import com.brand.blockus.content.BlazeBricks;
import com.brand.blockus.content.NewStones;
import com.brand.blockus.content.NewWoods;
import com.brand.blockus.content.ColoredTiles;
import com.brand.blockus.content.EndStoneRelated;
import com.brand.blockus.content.FoodBlocks;
import com.brand.blockus.content.FuturneoBlocks;
import com.brand.blockus.content.GlassRelated;
import com.brand.blockus.content.GlazedTerracottaPillars;
import com.brand.blockus.content.Hedge;
import com.brand.blockus.content.LargeFlowerPots;
import com.brand.blockus.content.FluidBricks;
import com.brand.blockus.content.LegacyBlocks;
import com.brand.blockus.content.MagmaBricks;
import com.brand.blockus.content.NetherBricksRelated;
import com.brand.blockus.content.NetherrackRelated;
import com.brand.blockus.content.NewBricks;
import com.brand.blockus.content.ObsidianRelated;
import com.brand.blockus.content.Other;
import com.brand.blockus.content.PaperRelated;
import com.brand.blockus.content.PatternedWools;
import com.brand.blockus.content.PrismarineRelated;
import com.brand.blockus.content.PurpurRelated;
import com.brand.blockus.content.QuartzRelated;
import com.brand.blockus.content.Rainbow;
import com.brand.blockus.content.RedstoneLamps;
import com.brand.blockus.content.SandstoneBricks;
import com.brand.blockus.content.Shingles;
import com.brand.blockus.content.SmallLogs;
import com.brand.blockus.content.SoulSandstone;
import com.brand.blockus.content.StainedStoneBricks;
import com.brand.blockus.content.StonesRelated;
import com.brand.blockus.content.TimberFrame;
import com.brand.blockus.world.BlockusGen;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.biome.Biome;

public class Blockus implements ModInitializer {
	
	public static final String MOD_ID = "blockus";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup BLOCKUS_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_building_blocks"), () -> new ItemStack(BlazeBricks.BLAZE_BRICKS));
	public static final ItemGroup BLOCKUS_DECORATIONS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_decorations"), () -> new ItemStack(Hedge.SMALL_HEDGE));
	public static final ItemGroup BLOCKUS_REDSTONE = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blockus_redstone"), () -> new ItemStack(Other.REDSTONE_SAND));

	@Override
	public void onInitialize() {
		for (Biome biome : Registry.BIOME)
		{
			BlockusGen.addMineables(biome);
			BlockusGen.addWhiteOakTrees(biome);
			BlockusGen.addPlainsWhiteOakTrees(biome);
		}
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> BlockusGen.addMineables(biome));
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> BlockusGen.addPlainsWhiteOakTrees(biome));
		
		new StonesRelated();
		new NewStones();
		new NewWoods();
		new SmallLogs();
		new TimberFrame();
		new Hedge();
		new LargeFlowerPots();
		new Barrels();
		new GlazedTerracottaPillars();
		new GlassRelated();
		new Asphalt();
		new Shingles();
		new FluidBricks();
		new MagmaBricks();
		new NewBricks();
		new SandstoneBricks();
		new SoulSandstone();
		new PrismarineRelated();
		new EndStoneRelated();
		new PurpurRelated();
		new ObsidianRelated();
		new Rainbow();
		new RedstoneLamps();
		new QuartzRelated();
		new PaperRelated();
		new NetherrackRelated();
		new NetherBricksRelated();
		new BlazeBricks();
		new FoodBlocks();
		new StainedStoneBricks();
		new PatternedWools();
		new ColoredTiles();
		new FuturneoBlocks();
		new Other();
		new LegacyBlocks();
		instance.init();
	 
	}
	
	public static boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
	      return type == EntityType.OCELOT || type == EntityType.PARROT;
	}
	
	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
	      return false;
	}
	
	public static boolean nothing(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
	      return false;
	}
}

