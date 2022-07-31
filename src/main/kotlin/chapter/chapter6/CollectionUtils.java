package chapter.chapter6;

import java.util.List;

public class CollectionUtils {
	public static List<String> uppercaseAll(List<String> items) {
		items.replaceAll(String::toUpperCase);
		return items;
	}
}
