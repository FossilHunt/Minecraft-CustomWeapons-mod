package net.teunis.customweaponsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.teunis.customweaponsmod.CustomWeaponsMod;
import net.teunis.customweaponsmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CustomWeaponsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DRAGONSLAYER);
        simpleItem(ModItems.DENSEIRON);
        simpleItem(ModItems.REVENANTHAMMER);
        simpleItem(ModItems.KUBIK);
        simpleItem(ModItems.REVENANT_SPAWN_EGG);
        }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CustomWeaponsMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}

//package net.teunis.customweaponsmod.datagen;
//
//import net.minecraft.data.PackOutput;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraftforge.client.model.generators.ItemModelBuilder;
//import net.minecraftforge.client.model.generators.ItemModelProvider;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import net.minecraftforge.registries.RegistryObject;
//import net.teunis.customweaponsmod.CustomWeaponsMod;
//import net.teunis.customweaponsmod.item.ModItems;
//
//public class ModItemModelProvider extends ItemModelProvider {
//
//    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
//        super(output, CustomWeaponsMod.MOD_ID, existingFileHelper);
//    }
//
//    @Override
//    protected void registerModels() {
//        // Multi-layer dragonslayer
//        layeredItem(ModItems.DRAGONSLAYER, "dragonslayer_base", "dragonslayer_overlay", "dragonslayer_glow");
//
//        // Single-layer items
//        simpleItem(ModItems.DENSEIRON);
//        simpleItem(ModItems.REVENANTHAMMER);
//        simpleItem(ModItems.KUBIK);
//        simpleItem(ModItems.REVENANT_SPAWN_EGG);
//    }
//
//    // For single-layer items
//    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
//        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
//                .texture("layer0", new ResourceLocation(CustomWeaponsMod.MOD_ID, "item/" + item.getId().getPath()));
//    }
//
//    // For multi-layer items
//    private ItemModelBuilder layeredItem(RegistryObject<Item> item, String... layers) {
//        ItemModelBuilder builder = withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"));
//        for (int i = 0; i < layers.length; i++) {
//            builder.texture("layer" + i, new ResourceLocation(CustomWeaponsMod.MOD_ID, "item/" + layers[i]));
//        }
//        return builder;
//    }
//}
