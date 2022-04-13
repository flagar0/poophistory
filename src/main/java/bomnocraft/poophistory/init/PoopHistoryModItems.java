
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package bomnocraft.poophistory.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.Item;

import java.util.List;
import java.util.ArrayList;

import bomnocraft.poophistory.item.PoopItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PoopHistoryModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item POOP = register(new PoopItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
