package ru.job4j.map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class SimpleHashMapTest {
	private SimpleHashMap<Integer, String> it;

	@Before
	public void setUp() {
		it = new SimpleHashMap<>();
	}

	@Test
	public void newNodesCanBeAdded() {
		it.insert(10, "one");
		assertThat(it.get(10), is("one"));
		it.insert(20, "two");
		assertThat(it.get(20), is("two"));
		it.insert(30, "three");
		assertThat(it.get(30), is("three"));
		it.insert(40, "four");
		assertThat(it.get(40), is("four"));
	}

	@Test
	public void nodesCanBeDeleted() {
		it.insert(10, "one");
		it.insert(20, "two");
		it.insert(30, "three");
		it.delete(20);
		it.delete(30);
		assertThat(it.get(10), is("one"));
		assertNull(it.get(20));
		assertNull(it.get(30));
	}

	@Test
	public void hashMapCanBeIncreased() {
		it.insert(10, "one");
		assertThat(it.insert(10, "one"), is(false));
		it.insert(20, "two");
		it.insert(30, "three");
		it.insert(40, "four");
		it.insert(50, "five");
		it.insert(60, "six");
		it.insert(70, "seven");
		it.insert(80, "eight");
		it.insert(90, "nine");
		it.insert(100, "ten");
		it.insert(110, "eleven");
		it.insert(120, "twelve");
		assertThat(it.getArrayLength(), is(32));
	}

	@Test(expected = NoSuchElementException.class)
	public void hashMapCanBeIterated() {
		it.insert(10, "one");
		it.insert(20, "two");
		it.insert(30, "three");
		it.insert(40, "four");
		assertThat(it.next(), is("four"));
		assertThat(it.next(), is("three"));
		assertThat(it.next(), is("two"));
		assertThat(it.next(), is("one"));
		it.next();
	}

}
