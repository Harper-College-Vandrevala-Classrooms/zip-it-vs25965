package com.csc;
import java.util.HashMap;
import java.util.List;

public class Zipper {

public static void main(String[] args) throws SizeNotEqualException
{
       //driver program to manually test
  
    Integer[] list1 = new Integer[] {1, 3, 5, 7, 9, 11, 13, 15};
    Integer[] list2 = new Integer[] {2, 4, 6, 8, 10, 12, 14, 16, 17, 18};
    Integer[] zipped = zip(list1, list2, Integer.class);
    int zippedLength = zipped.length;
    
    for (int i = 0; i < zippedLength; i++)
    {
        System.out.println(zipped[i]);
    }

    Integer[] _list = new Integer [] {1,2,3};
    Integer[] _list2 = new Integer[] {4,5,6};
    Integer[] _zipped = zip(_list,_list2,Integer.class);
    int _zl = _zipped.length;
    System.err.println("\nNew array\n");
    for(int l = 0; l < _zl; l++)
    {
      System.out.println(  _zipped[l]);
    }

    Integer[] list_  = new Integer[] {2,4,6,8,10,12,14,16,17,18};
    Integer[] list2_ = new Integer[] {1,3,5,7,9,11,13,15};
    Integer[] zip_   = zip(list_, list2_,Integer.class);
         int zl_ = zip_.length;
    System.err.println("\nNew array\n");
    for(int s = 0; s < zl_ ; s++)
    {
      System.out.println( zip_[s]);
    }

    String [] strinn = new String[] {"Mango" , "Coconut", "Pinaple", "Straberry"};
    String [] strinnn = new String[] {"Apple" , "blackberry", "blueberry", "orange"};
    String [] resu = zip(strinn,strinnn,String.class);
    int ll = resu.length;
    for(int s = 0; s < ll; s++)
    {
      System.out.print(resu[s] +  ", " );
    }
    
    //Using HashMap - Generic List to hashmapify method for Portfolio 2 
    List<String> Personal = List.of("Sarah", "John", "Alex", "Monica");
    List<Integer> Ids = List.of(123, 456, 789,765);
    
    System.out.println("\nHashMap of Personal and Ids: " + hashmapify(Personal,Ids) + "\n\n");
    

    //List with not equal size to show Exception 
    List<String> Personal1 = List.of("Sarah", "John", "Alex");
    List<Integer> Ids1 = List.of(123, 456, 789,765);
    hashmapify(Personal1,Ids1);
}

public static <T> T[] zip(T[] _list1, T[] _list2, Class<T> clazz)
{
    int _length1 = _list1.length;
    int _length2 = _list2.length;
    int _length3 = _length1 + _length2;
    @SuppressWarnings("unchecked")
    T[] mergedList = (T[]) java.lang.reflect.Array.newInstance(clazz, _length3);

          for (int k = 0; k < _length1; k++)
          {
            if (k * 2 < _length3)
            {
                mergedList[k * 2] = _list1[k];
            }
            
          }
          for (int j = 0; j < _length2; j++)
          {
            if ((j * 2) + 1 < _length3)
            {
                mergedList[(j * 2) + 1] = _list2[j];
            }

          }
        
          if (_length1 < _length2)
          {
           
              int diff = _length2 - _length1;
              int ind = (_length2 - diff);
              int ind3 = _length3 - diff;
              
             
                for (int i = 0; i < diff; i++)
              {
                mergedList[ind3 + i] = _list2[ind + i];
              }
               
          }
       
          if (_length1 > _length2)
          {
           
            int diff = _length1 - _length2;
            int ind = _length2;
            int ind3 = _length2 * 2;
    
            for (int i = 0; i < diff; i++) {
                mergedList[ind3 + i] = _list1[ind + i];
            }
               
          }
    
   return mergedList;
    
}

public static HashMap<String, Integer> hashmapify (List<String> stringList, List<Integer> intList)  throws SizeNotEqualException
{
  HashMap<String, Integer> MapMerged = new HashMap<>();

   int SListSize = stringList.size();
   int IListSize = intList.size();
    
      if (SListSize != IListSize){
        throw new SizeNotEqualException("The size of the lists are not equal");
      }
      
      for (int i = 0; i < SListSize && i < IListSize; i++) {
        MapMerged.put(stringList.get(i), intList.get(i));
    }
 


  return  MapMerged;
}




}

