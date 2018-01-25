package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TrelloMapperTestSuite {
    @Test
    public void testMapToBoards() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();

        List<TrelloListDto> trelloListDtos1 = new ArrayList<>();
        IntStream.rangeClosed(1, 10)
                .forEach(n -> trelloListDtos1.add(new TrelloListDto("id1." + n, "Name list1." + n, false)));
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Board name 1", "id1", trelloListDtos1);

        List<TrelloListDto> trelloListDtos2 = new ArrayList<>();
        IntStream.rangeClosed(11, 20)
                .forEach(n -> trelloListDtos2.add(new TrelloListDto("id2." + n, "Name list2." + n, true)));
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Board name 2", "id2", trelloListDtos2);

        List<TrelloListDto> trelloListDtos3 = new ArrayList<>();
        IntStream.rangeClosed(21, 30)
                .forEach(n -> trelloListDtos3.add(new TrelloListDto("id3." + n, "Name list3." + n, false)));
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("Board name 3", "id3", trelloListDtos3);

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);
        trelloBoardDtoList.add(trelloBoardDto3);

        //When
        List<TrelloBoard> trelloBoardListMapped = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        Assert.assertEquals(3, trelloBoardListMapped.size());
        Assert.assertEquals(10, trelloBoardListMapped.get(2).getLists().size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();

        List<TrelloList> trelloLists1 = new ArrayList<>();
        IntStream.rangeClosed(1, 10)
                .forEach(n -> trelloLists1.add(new TrelloList("id1." + n, "Name list1." + n, false)));
        TrelloBoard trelloBoard1 = new TrelloBoard("Board name 1", "id1", trelloLists1);

        List<TrelloList> trelloLists2 = new ArrayList<>();
        IntStream.rangeClosed(11, 20)
                .forEach(n -> trelloLists2.add(new TrelloList("id2." + n, "Name list2." + n, true)));
        TrelloBoard trelloBoard2 = new TrelloBoard("Board name 2", "id2", trelloLists2);

        List<TrelloList> trelloLists3 = new ArrayList<>();
        IntStream.rangeClosed(21, 30)
                .forEach(n -> trelloLists3.add(new TrelloList("id3." + n, "Name list3." + n, false)));
        TrelloBoard trelloBoard3 = new TrelloBoard("Board name 3", "id3", trelloLists3);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        trelloBoardList.add(trelloBoard3);

        //When
        List<TrelloBoardDto> trelloBoardDtoListMapped = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        Assert.assertEquals(3, trelloBoardDtoListMapped.size());
        Assert.assertEquals(10, trelloBoardDtoListMapped.get(2).getLists().size());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        IntStream.rangeClosed(1, 10)
                .forEach(n -> trelloListDtos.add(new TrelloListDto("id " + n, "Name " + n, false)));
        //When
        List<TrelloList> trelloListsMapped = trelloMapper.mapToList(trelloListDtos);
        //Then
        Assert.assertEquals(10, trelloListsMapped.size());
        Assert.assertEquals("id 10", trelloListsMapped.get(9).getId());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> trelloLists = new ArrayList<>();
        IntStream.rangeClosed(1, 10)
                .forEach(n -> trelloLists.add(new TrelloList("id " + n, "Name " + n, true)));
        //When
        List<TrelloListDto> trelloListDtosMapped = trelloMapper.mapToListDto(trelloLists);
        //Then
        Assert.assertEquals(10, trelloListDtosMapped.size());
        Assert.assertEquals("id 10", trelloListDtosMapped.get(9).getId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCardDto trelloCardDto = new TrelloCardDto("Cardname", "Carddescription", "1", "id100");
        //When
        TrelloCard trelloCardMapped = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals("Cardname", trelloCardMapped.getName());
        Assert.assertEquals("Carddescription", trelloCardMapped.getDescription());
        Assert.assertEquals("1", trelloCardMapped.getPos());
        Assert.assertEquals("id100", trelloCardMapped.getListId());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("Cardname", "Carddescription", "1", "id100");
        //When
        TrelloCardDto trelloCardDtoMapped = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals("Cardname", trelloCardDtoMapped.getName());
        Assert.assertEquals("Carddescription", trelloCardDtoMapped.getDescription());
        Assert.assertEquals("1", trelloCardDtoMapped.getPos());
        Assert.assertEquals("id100", trelloCardDtoMapped.getListId());
    }
}
