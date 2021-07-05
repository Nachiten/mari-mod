package nachiten.mari.mod.baseClass;

import nachiten.mari.mod.blockItems.*;
import nachiten.mari.mod.blocks.*;
import nachiten.mari.mod.foods.*;
import nachiten.mari.mod.items.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MariMod implements ModInitializer {

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("marimod", "marimod_items"),
			() -> new ItemStack(Blocks.GRASS_BLOCK));

	public static final Block MARIHUANA_BLOCK = new MarihuanaBlock(FabricBlockSettings.of(Material.WOOL).strength(0.5f).resistance(0.5f));
	public static final BlockItem MARIHUANA_BLOCK_ITEM = new MarihuanaBlockItem(MARIHUANA_BLOCK, new FabricItemSettings().group(MariMod.ITEM_GROUP));
	public static final Item MARIHUANA = new Marihuana(new Item.Settings().group(MariMod.ITEM_GROUP).maxCount(32));
	public static final Item COCAINA = new Cocaina(new Item.Settings().group(MariMod.ITEM_GROUP).maxCount(32).food(CocainaFood.COCAINA_COMIDA));
	public static final Item PORRO = new Porro(new Item.Settings().group(MariMod.ITEM_GROUP).maxCount(8).food(PorroFood.PORRO_COMIDA));


	@Override
	public void onInitialize() {
		registrarObjetos();
	}

	void registrarObjetos() {
		Registry.register(Registry.BLOCK, new Identifier("marimod", "marihuana_block"), MARIHUANA_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("marimod", "marihuana_block_item"), MARIHUANA_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier("marimod", "marihuana"), MARIHUANA);
		Registry.register(Registry.ITEM, new Identifier("marimod", "cocaina"), COCAINA);
		Registry.register(Registry.ITEM, new Identifier("marimod", "porro"), PORRO);
	}
}
