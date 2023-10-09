package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Attractions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.MarshalledObject;
import java.util.List;

public class JdbcAttractionsDaoTests extends BaseDaoTests {

    protected static final Attractions ATTRACTION_1 = new Attractions (1, "National Gallery of Art", "Constitution Ave. NW, Washington, DC 20565",
            "The National Gallery of Art, and its attached Sculpture Garden, is a national art museum in Washington, D.C., United States, located on the National Mall, between 3rd and 9th Streets, at Constitution Avenue NW.",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQEzfvN0a5h2kRsyhpJSIw9eSqB13fYogK3dBN0hZNikc17k-1q", "Museum");

    protected static final Attractions ATTRACTION_2 = new Attractions (2,"Smithsonian National Museum of Natural History", "10th St. & Constitution Ave. NW, Washington, DC 20560", "The National Museum of Natural History is a natural history museum administered by the Smithsonian Institution, located on the National Mall in Washington, D.C., United States. It has free admission and is open 364 days a year. In 2022, with 3.9 million visitors, it was the most-visited museum in the United States.",
            "https://t1.gstatic.com/images?q=tbn:ANd9GcRc1umdEPTXUzw3bKF4m4ZJgLmxGC7zKz__UcPtKBdM1uebBj0i", "Museum");

    protected static final Attractions ATTRACTION_3 = new Attractions (3, "National Air and Space Museum", "600 Independence Ave SW, Washington, DC 20560", "The National Air and Space Museum of the Smithsonian Institution, is a museum in Washington, D.C., in the United States dedicated to human flight and space exploration. Established in 1946 as the National Air Museum, its main building opened on the National Mall near L'Enfant Plaza in 1976.",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRM7rHKDn4KhbnAfv2otT-knCvYfzqfSA8GdO5eWkSMHRbdWS0z", "Museum");

    protected static final Attractions ATTRACTION_4 = new Attractions (4,"United States Holocaust Memorial Museum", "100 Raoul Wallenberg Pl SW, Washington, DC 20024", "The United States Holocaust Memorial Museum is the United States'' official memorial to the Holocaust. Adjacent to the National Mall in Washington, D.C., the USHMM provides for the documentation, study, and interpretation of Holocaust history.",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTYd6QSJ3mz8QUely6JXDS1FJEHHsPlW0oYxYqGne2BJ6tQMmY2", "Museum");

    protected static final Attractions ATTRACTION_5 = new Attractions(5, "Jefferson Memorial", "16 E Basin Dr SW, Washington, DC 20242", "The Jefferson Memorial is a presidential memorial built in Washington, D.C., between 1939 and 1943 in honor of Thomas Jefferson, the principal author of the United States Declaration of Independence.",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRNMxhs60y1ruXngKYKz86lBIQLKGKuWuS3LqfpP2tLP0NLpv2I", "Monument");

    protected static final Attractions ATTRACTION_6 = new Attractions (6, "Korean War Memorial", "900 Ohio Dr SW, Washington, DC 20024", "The Korean War Veterans Memorial is located in Washington, D.C.'s West Potomac Park, southeast of the Lincoln Memorial and just south of the Reflecting Pool on the National Mall. It memorializes those who served in the Korean War. The national memorial was dedicated in 1995",
        "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRiMT0mGIad1ogUkyiaKyxAqvs9TsHBuZQG1zY0wVwhmXpYDbBT", "Monument");
    JdbcAttractionsDao sut;

    @Before
    public void setup () {
     sut =   new JdbcAttractionsDao(dataSource);
    }



    @Test
    public void get_all_museums_test() {
        List<Attractions> museums = sut.getAllMuseums();
        AssertAttractionsMatch(ATTRACTION_1,museums.get(0));
        AssertAttractionsMatch(ATTRACTION_2, museums.get(1));
        AssertAttractionsMatch(ATTRACTION_3, museums.get(2));
    }

    @Test
    public void get_all_monuments_test() {
        List <Attractions> monuments = sut.getAllMonuments();
        AssertAttractionsMatch(ATTRACTION_5, monuments.get(0));
        AssertAttractionsMatch(ATTRACTION_6, monuments.get(1));
        Assert.assertEquals(2, monuments.size());

    }
    @Test
    public void add_attraction_test () {
        Attractions newAttraction  = new Attractions("Random name", "Random address", "Random description", "Random type");
        Attractions inDb = sut.addAttraction(newAttraction);
        AssertAttractionsMatch(newAttraction,inDb);

    }

    @Test
    public void update_attraction_test () {
        Attractions ATTRACTION_7 = new Attractions (6, "lol", "yabba dabba", "The Korean War Veterans Memorial is located in Washington, D.C.'s West Potomac Park, southeast of the Lincoln Memorial and just south of the Reflecting Pool on the National Mall. It memorializes those who served in the Korean War. The national memorial was dedicated in 1995",
                 "Monument");

        Attractions update = sut.updateAttraction(ATTRACTION_7);
        AssertAttractionsMatch(ATTRACTION_7, update);
    }

    @Test
    public void findAttractionsById (){

        Attractions inDB = sut.getAttractionById(1);
        AssertAttractionsMatch(ATTRACTION_1, inDB);


    }


    public void AssertAttractionsMatch (Attractions expected, Attractions result) {
        if (expected.getId() != 0){
            Assert.assertEquals(expected.getId(),result.getId());
        }

        if (expected.getName() != null) {
            Assert.assertEquals(expected.getName(), result.getName());
        }

        if (expected.getAddress() != null) {
            Assert.assertEquals(expected.getAddress(), result.getAddress());
        }

        if (expected.getDescription() != null) {
            Assert.assertEquals(expected.getDescription(), result.getDescription());
        }

        if (expected.getImage() != null) {
            Assert.assertEquals(expected.getImage(), result.getImage());
        }

        if (expected.getType() != null) {
            Assert.assertEquals(expected.getType(), result.getType());
        }
    }


}
