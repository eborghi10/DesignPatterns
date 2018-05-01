package com.emiliano.compositepattern;

import java.util.ArrayList;
import java.util.Iterator;

public class SongGroup extends SongComponent {

    private ArrayList<SongComponent> songComponents;

    private String groupName;
    private String groupDescription;

    SongGroup(String newGroupName, String newGroupDescription) {
        groupName = newGroupName;
        groupDescription = newGroupDescription;
        songComponents = new ArrayList<>();
    }

    String getGroupName() {
        return groupName;
    }

    String getGroupDescription() {
        return groupDescription;
    }

    @Override
    public void add(SongComponent newSongComponent) {
        songComponents.add(newSongComponent);
    }

    @Override
    public void remove(SongComponent songComponent) {
        songComponents.remove(songComponent);
    }

    @Override
    public SongComponent getComponent(int index) {
        return songComponents.get(index);
    }

    @Override
    public void displaySongInfo() {
        System.out.println(getGroupName() + ' ' + getGroupDescription());

        // There is no need to use Iterator because we are not modifying "songComponents"
        Iterator songIterator = songComponents.iterator();

        while (songIterator.hasNext()) {
            SongComponent songInfo = (SongComponent) songIterator.next();
            songInfo.displaySongInfo();
        }
    }
}
