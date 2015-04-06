package com.github.javacodekata.lambda.stream;

import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListTransformer {

	private final List<String> values;

	private ListTransformer(List<String> values) {
		this.values = values;
	}

	public static ListTransformer of(List<String> values) {
		checkNotNull(values);
		return new ListTransformer(ImmutableList.copyOf(values));
	}

	/**
	 * This method should take the String List and sort all the String elements in ascending (ASCII) order.
	 * 
	 * @return The sorted values in ascending ASCII order.
	 */
	public List<String> getSortedStrings() {
		return values.stream().sorted().collect(Collectors.toList());
	}

	/**
	 * This method should take the String List and:
	 * <ol>
	 * <li>filter the elements that contains one or more digits;</li>
	 * <li>transform (map) the remaining Strings into Integers;</li>
	 * <li>sort the Integers in ascending order.</li>
	 * </ol>
	 * 
	 * @return
	 */
	public List<Integer> getSortedIntegers() {
		return values.stream().filter(this::isInteger).mapToInt(Integer::parseInt).sorted().boxed().collect(Collectors.toList());
	}

	/**
	 * This method should take the String List and:
	 * <ol>
	 * <li>filter the elements that contains one or more digits;</li>
	 * <li>transform (map) the remaining Strings into Integers;</li>
	 * <li>sort the Integers in descending order.</li>
	 * </ol>
	 * 
	 * @return
	 */
	public List<Integer> getSortedDescendingIntegers() {
		return values.stream().filter(this::isInteger).map(Integer::parseInt).sorted((a,b)->b.compareTo(a))
				.collect(Collectors.toList());
	}

	private boolean isInteger(String x) {
		try {
			Integer.parseInt(x);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
