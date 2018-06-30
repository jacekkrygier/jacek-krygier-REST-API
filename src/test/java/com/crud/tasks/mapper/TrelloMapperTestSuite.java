package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper mapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        List<TrelloBoardDto> trelloBoardDto = Arrays.asList(
                new TrelloBoardDto("1", "List1", trelloListDto),
                new TrelloBoardDto("2", "List2", trelloListDto));

        //When
        List<TrelloBoard> trelloBoards = mapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(2, trelloBoards.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();

        List<TrelloBoard> trelloBoards = Arrays.asList(
                new TrelloBoard("1", "List1", trelloList),
                new TrelloBoard("2", "List2", trelloList));

        //When
        List<TrelloBoardDto> trelloBoardDtos = mapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(2, trelloBoardDtos.size());

    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = Arrays.asList(
                new TrelloListDto("1", "List1", true),
                new TrelloListDto("2", "List2", true));

        //When
        List<TrelloList> trelloLists = mapper.mapToList(trelloListDto);
        //Then
        assertEquals(2, trelloLists.size());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloList = Arrays.asList(
                new TrelloList("1", "List1", true),
                new TrelloList("2", "List2", true));
        //When
        List<TrelloListDto> trelloListDtos = mapper.mapToListDto(trelloList);
        //Then
        assertEquals(2, trelloListDtos.size());

    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "Testing", "top", "1");
        //When
        TrelloCard trelloCard = mapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("Test", trelloCard.getName());
        assertEquals("1", trelloCard.getListId());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test", "Testing", "top", "1");
        //When
        TrelloCardDto trelloCardDto = mapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Test", trelloCardDto.getName());
        assertEquals("1", trelloCardDto.getListId());
    }
}