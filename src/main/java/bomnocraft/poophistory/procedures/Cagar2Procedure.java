package bomnocraft.poophistory.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import bomnocraft.poophistory.init.PoopHistoryModItems;
import bomnocraft.poophistory.init.PoopHistoryModGameRules;

@Mod.EventBusSubscriber
public class Cagar2Procedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		Entity entity = event.getEntityLiving();
		execute(event, entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double tempo = 0;
		double range = 0;
		double ale = 0;
		if (world.getLevelData().getGameRules().getBoolean(PoopHistoryModGameRules.COCO)) {
			if (entity.getPersistentData().getDouble("poopTimer") == 0) {
				entity.getPersistentData().putDouble("poopTimer", (Math.round(Math.random() * (1 + 2500 - 500)) + 500));
			} else {
				entity.getPersistentData().putDouble("poopTimer", (entity.getPersistentData().getDouble("poopTimer") - 1));
			}
		}
		if (entity.getPersistentData().getDouble("poopTimer") == 0) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEFINED : false) {
				range = 1 + 10 - 1;
				ale = Math.random() * range + 1;
				if (ale <= (world.getLevelData().getGameRules().getInt(PoopHistoryModGameRules.CHANCECAGAR))) {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()),
								new ItemStack(PoopHistoryModItems.POOP));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("poop_history:ambient.pum")), SoundSource.AMBIENT, 1,
									(float) 0.7);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("poop_history:ambient.pum")),
									SoundSource.AMBIENT, 1, (float) 0.7, false);
						}
					}
				}
			}
		}
	}
}
