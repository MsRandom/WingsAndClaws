package net.msrandom.wings;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WingsSounds {
    public static final WingsRegisterer<SoundEvent> REGISTRY = new WingsRegisterer<>(Registry.SOUND_EVENT);
    public static final SoundEvent DED_AMBIENT = create("ded.ambient");
    public static final SoundEvent DED_HURT = create("ded.hurt");
    public static final SoundEvent DED_DEATH = create("ded.death");
    public static final SoundEvent PLOWHEAD_AMBIENT = create("plowhead.ambient");
    public static final SoundEvent PLOWHEAD_HURT = create("plowhead.hurt");
    public static final SoundEvent PLOWHEAD_DEATH = create("plowhead.death");
    public static final SoundEvent PLOWHEAD_ANGRY = create("plowhead.angry");
    public static final SoundEvent BATTLE_HORN = create("horn.use");

    public static final SoundEvent MUSIC_BLISSFUL_DUNES = create("music.blissful_dunes");

    private static SoundEvent create(String name) {
        return REGISTRY.register(name, new SoundEvent(new Identifier(WingsAndClaws.MOD_ID, name)));
    }
}
