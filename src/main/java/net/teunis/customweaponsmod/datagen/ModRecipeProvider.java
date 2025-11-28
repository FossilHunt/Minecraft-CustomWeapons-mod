package net.teunis.customweaponsmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.teunis.customweaponsmod.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
   public ModRecipeProvider(PackOutput pOutput) {
       super(pOutput);
   }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DENSEIRON.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.IRON_BLOCK)
                .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DRAGONSLAYER.get())
                .pattern(" N ")
                .pattern(" N ")
                .pattern(" D ")
                .define('N', Items.NETHERITE_INGOT)
                .define('D', ModItems.DENSEIRON.get())
                .unlockedBy(getHasName(ModItems.DENSEIRON.get()), has(ModItems.DENSEIRON.get()))
                .save(pWriter);


    }
}
