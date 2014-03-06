/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitmudproject;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Tomoe
 */
public class RoomList
{

    ArrayList<Room> roomarray = new ArrayList();
    MonsterList monsterlist;

    public RoomList(MonsterList monsterlist)
    {
        this.monsterlist = monsterlist;
    }

    public ArrayList<Room> createRooms()
    {
        ArrayList<Monster> monsterarray = monsterlist.getMonsterArray();
        Collections.shuffle(monsterarray);

        for (int i = 0; i < monsterarray.size(); i++)

        {
            roomarray.add(new Room(monsterarray.get(i)));

        }

        return roomarray;
    }

}
