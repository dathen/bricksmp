package net.fabricmc.brickcraft;

import net.fabricmc.api.ModInitializer;

public class BrickCraftMod implements ModInitializer {
	

	public static final Item ELYTRA_FRAME = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item ELYTRA_WING = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	private static final Identifier ENDER_DRAGON_LOOT_TABLE_ID = new Identifier("minecraft", "entities/ender_dragon");

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("brickcraft", "elytra_frame"), ELYTRA_FRAME);
		Registry.register(Registry.ITEM, new Identifier("brickcraft", "elytra_wing"), ELYTRA_WING);
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
			if (ENDER_DRAGON_LOOT_TABLE_ID.equals(id)) {
		        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                .withRolls(ConstantLootTableRange.create(1))
                .withEntry(ItemEntry.builder(Items.DRAGON_HEAD));
 
        		supplier.withPool(poolBuilder);
			}
		});
	}
}
