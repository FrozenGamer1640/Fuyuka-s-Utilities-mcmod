package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;

public class CleanNullEntitiesFromTargetArraysProcedure {
	public static void execute() {
		double numIterator = 0;
		numIterator = 0;
		while (numIterator < FuyukasUtilitiesModVariables.TpSwapTargets1.size()) {
			if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) numIterator) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
				numIterator = numIterator + 1;
			} else {
				FuyukasUtilitiesModVariables.TpSwapTargets1.remove((int) numIterator);
			}
		}
		if (FuyukasUtilitiesModVariables.TpSwap_TeamMode) {
			numIterator = 0;
			while (numIterator < FuyukasUtilitiesModVariables.TpSwapTargets2.size()) {
				if ((FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) numIterator) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
					numIterator = numIterator + 1;
				} else {
					FuyukasUtilitiesModVariables.TpSwapTargets2.remove((int) numIterator);
				}
			}
		}
	}
}
