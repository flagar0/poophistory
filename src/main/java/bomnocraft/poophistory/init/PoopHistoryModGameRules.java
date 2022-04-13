
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package bomnocraft.poophistory.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PoopHistoryModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> COCO = GameRules.register("coco", GameRules.Category.UPDATES,
			GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> CHANCECAGAR = GameRules.register("chanceCagar", GameRules.Category.UPDATES,
			GameRules.IntegerValue.create(2));
}
