package gitmudproject;

import java.util.ArrayList;


public class RoomList
{

    ArrayList<Room> roomarray = new ArrayList();


    public ArrayList<Room> createRooms()
    {
        MonsterLogic monsterCreator = new MonsterLogic();
        for (int i = 0; i < 10; i++)

        {
            roomarray.add(new Room(monsterCreator.createRandomMonster(0)));

        }

        return roomarray;
    }

}
