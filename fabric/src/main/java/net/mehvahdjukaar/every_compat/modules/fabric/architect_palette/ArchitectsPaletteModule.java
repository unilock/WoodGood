package net.mehvahdjukaar.every_compat.modules.fabric.architect_palette;

import com.slomaxonical.architectspalette.blocks.RailingBlock;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;

public class ArchitectsPaletteModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> railings;

    public ArchitectsPaletteModule(String modId) {
        super(modId, "ap");

        railings = SimpleEntrySet.builder(WoodType.class, "railing",
                        () -> getModBlock("oak_railing"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new RailingBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .defaultRecipe()
                .setTabKey(() -> CreativeModeTabs.BUILDING_BLOCKS)
                .build();

        this.addEntry(railings);
    }

}
