/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gitmudproject;

/**
 *
 * @author Peter
 */
public class Room
{
    
    public Room up, down, start, temporary;

    public boolean addRoom(Room newRoom)
    {
        if (start == null) //The special case where the list is empty!
        {
            start = newRoom;
            start.up = null;
            start.down = null;
        }
        else  //...all the other cases
        {
            //Run to the end of the list of houses and then add the new house:
            Room temp;  //New temporary pointer used only in this method.
            temp = start;  //Set the temp pointer to the same house as the first pointer.

            if (start.up == null)
            {
                start.up = newRoom;
                newRoom.down = start;
            }
            else
                

            while (temp.up != null)  //as long as the house objects right neighbour is NOT null, then we advance down the neighbourhood
            {
                temp = temp.up; //Moving the temp poiner to point to the house to the top
            }

        }
        return true; //I CAN NEVER FAIL!!! LONG LIVE HUBRIS!!!
    }
}
