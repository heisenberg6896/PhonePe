package service.Search;

import constants.SearchType;
import exception.NoSuchSearchTypeExists;

public class SearchFactory {

    public static Search getSearchResultsByType(String searchType){
        if(SearchType.FIRST_NAME.name().equals(searchType)){
            return new SearchByFirstName();
        }else if(SearchType.LAST_NAME.name().equals(searchType)){
            return new SearchByLastName();
        }else if(SearchType.PHONE_NUMBER.name().equals(searchType)) {
            return new SearchByPhoneNumber();
        }else{
            throw new NoSuchSearchTypeExists();
        }
    }
}
