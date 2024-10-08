package com.csc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZipperTest {

  Zipper zipper;

  @BeforeEach
  void setUp() {
    zipper = new Zipper();
  }

  @Test
  void itWorks1() {
    
    Integer[] expected = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
    Integer[] list1 = new Integer[] {1, 3, 5, 7, 9, 11, 13, 15};
    Integer[] list2 = new Integer[] {2, 4, 6, 8, 10, 12, 14, 16, 17, 18};
    Integer[] zipped = Zipper.zip(list1, list2, Integer.class);
    assertArrayEquals( expected, zipped );
  }


  @Test
  void itWorks2() {
    
    Integer[] expected2 = {1,4,2,5,3,6};
    Integer[] _list = new Integer [] {1,2,3};
    Integer[] _list2 = new Integer[] {4,5,6};
    Integer[] _zipped = Zipper.zip(_list,_list2,Integer.class);
    assertArrayEquals( expected2, _zipped );
  }

  @Test
  void itWorks3() {
    
    Integer[] expected3 = {2,1,4,3,6,5,8,7,10,9,12,11,14,13,16,15,17,18};
    Integer[] list_  = new Integer[] {2,4,6,8,10,12,14,16,17,18};
    Integer[] list2_ = new Integer[] {1,3,5,7,9,11,13,15};
    Integer[] zip_   = Zipper.zip(list_, list2_,Integer.class);
    assertArrayEquals( expected3, zip_ );
  }

  @Test
  void itWorks4() {
    
    String [] expected4 = new String[] {"Mango", "Apple", "Coconut", "blackberry", "Pinaple", "blueberry", "Straberry", "orange"};
    String [] strinn = new String[] {"Mango" , "Coconut", "Pinaple", "Straberry"};
    String [] strinnn = new String[] {"Apple" , "blackberry", "blueberry", "orange"};
    String [] resu = Zipper.zip(strinn,strinnn,String.class);
    assertArrayEquals( expected4, resu );
  }
}
