package nachiten.mari.mod.baseClass;

import nachiten.mari.mod.blockItems.*;
import nachiten.mari.mod.blocks.*;
import nachiten.mari.mod.foods.*;
import nachiten.mari.mod.items.*;
import nachiten.mari.mod.mariCrop.MariCropBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MariMod implements ModInitializer {

	static final String modName = "marimod";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(modName, "marimod_items"),
			() -> new ItemStack(Blocks.GRASS_BLOCK));

	public static final Block MARIHUANA_BLOCK = new MarihuanaBlock(FabricBlockSettings.of(Material.WOOL).strength(0.5f).resistance(0.5f));
	public static final BlockItem MARIHUANA_BLOCK_ITEM = new MarihuanaBlockItem(MARIHUANA_BLOCK, new FabricItemSettings().group(MariMod.ITEM_GROUP));
	public static final Item MARIHUANA = new Marihuana(new Item.Settings().group(MariMod.ITEM_GROUP).maxCount(32));
	public static final Item COCAINA = new Cocaina(new Item.Settings().group(MariMod.ITEM_GROUP).maxCount(32).food(CocainaFood.COCAINA_COMIDA));
	public static final Item PORRO = new Porro(new Item.Settings().group(MariMod.ITEM_GROUP).maxCount(8).food(PorroFood.PORRO_COMIDA));

	public static final CropBlock MARIHUANA_CROP_BLOCK = new MariCropBlock(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item MARIHUANA_SEEDS = new AliasedBlockItem(MariMod.MARIHUANA_CROP_BLOCK, new Item.Settings().group(MariMod.ITEM_GROUP));

	// No magic constants!
	private static final Identifier GRASS_LOOT_TABLE_ID = Blocks.GRASS.getLootTableId();

	@Override
	public void onInitialize() {
		registrarObjetos();

		registrarSemillasMarihuana();

		registrarLootTablesPersonalizadas();
	}

	private void registrarLootTablesPersonalizadas() {
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
			if (GRASS_LOOT_TABLE_ID.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.rolls(ConstantLootNumberProvider.create(3))
						.with(ItemEntry.builder(MARIHUANA_SEEDS));

				table.pool(poolBuilder);
			}
		});
	}

	void registrarObjetos() {
		Registry.register(Registry.BLOCK, new Identifier(modName, "marihuana_block"), MARIHUANA_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(modName, "marihuana_block_item"), MARIHUANA_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(modName, "marihuana"), MARIHUANA);
		Registry.register(Registry.ITEM, new Identifier(modName, "cocaina"), COCAINA);
		Registry.register(Registry.ITEM, new Identifier(modName, "porro"), PORRO);
	}

	void registrarSemillasMarihuana(){
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), MARIHUANA_CROP_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier(modName,"marihuana_crop_block"), MARIHUANA_CROP_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(modName,"marihuana_seeds"), MARIHUANA_SEEDS);
	}


}
