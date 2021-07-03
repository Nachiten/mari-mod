package nachiten.mari.mod.baseClass;

import nachiten.mari.mod.blockItems.MarihuanaBlockItem;
import nachiten.mari.mod.blocks.MarihuanaBlock;
import nachiten.mari.mod.items.Cocaina;
import nachiten.mari.mod.items.Marihuana;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MariMod implements ModInitializer {

	public static final Block MARIHUANA_BLOCK = new MarihuanaBlock(FabricBlockSettings.of(Material.METAL).strength(0.5f).resistance(0.5f));
	public static final BlockItem MARIHUANA_BLOCK_ITEM = new MarihuanaBlockItem(MARIHUANA_BLOCK, new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item MARIHUANA = new Marihuana(new Item.Settings().group(ItemGroup.MISC).maxCount(16));
	public static final Item COCAINA = new Cocaina(new Item.Settings().group(ItemGroup.MISC).maxCount(16));

	@Override
	public void onInitialize() {
		registrarObjetos();
	}

	void registrarObjetos() {
		Registry.register(Registry.BLOCK, new Identifier("marimod", "marihuana_block"), MARIHUANA_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("marimod", "marihuana_block_item"), MARIHUANA_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier("marimod", "marihuana"), MARIHUANA);
		Registry.register(Registry.ITEM, new Identifier("marimod", "cocaina"), COCAINA);
	}
}
