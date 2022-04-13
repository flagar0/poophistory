
package bomnocraft.poophistory.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class PoopItem extends Item {
	public PoopItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("poop");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
