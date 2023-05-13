package com.example.demo.mapper.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.example.demo.dtos.book.OrderItemBookDto;
import com.example.demo.models.book.Book;

@Mapper(uses = { AuthorDtoMapper.class }, componentModel = "spring")
public interface BookMapper {
	@Mappings({ @Mapping(target = "id", source = "bookId"), @Mapping(target = "name", source = "name"),
			@Mapping(target = "author", source = "author"), @Mapping(target = "price", source = "price"),
			@Mapping(target = "coverId", source = "cover.imageId"),

			@Mapping(target = "quantity", source = "quantity") })
	OrderItemBookDto getDto(Book book);
}
