package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterator<V> {
	private Node<K, V>[] hashTable;
	private int size;
	private float increaseValue;
	private float threshold;
	private int index;

	public SimpleHashMap() {
		size = 0;
		hashTable = new Node[16];
		increaseValue = 0.45f;
		threshold = hashTable.length * increaseValue;
	}

	public int getArrayLength() {
		return hashTable.length;
	}

	public boolean insert(K key, V value) {
		if ((size + 1) >= threshold) {
			arrayDouble();
		}
		Node<K, V> newNode = new Node(key, value);
		int index = newNode.hash();
		if (hashTable[index] == null) {
			hashTable[index] = newNode;
			size++;
			return true;
		} else
			return false;
	};

	private void arrayDouble() {
		Node<K, V>[] tempTable = new Node[hashTable.length * 2];
		System.arraycopy(hashTable, 0, tempTable, 0, hashTable.length);
		hashTable = tempTable;
		threshold = hashTable.length * increaseValue;
	}

	public V get(K key) throws NoSuchElementException {
		Node<K, V> newNode = new Node(key);
		Node<K, V> tableNode = hashTable[newNode.hash(key)];
		if (tableNode == null) {
			throw new NoSuchElementException("No such element, try again");
		}
		return tableNode.value;
	};

	public boolean delete(K key) {
		Node<K, V> newNode = new Node(key);
		Node<K, V> tableNode = hashTable[newNode.hash(key)];
		tableNode.setKey(null);
		tableNode.setValue(null);
		return true;
	};

	public V next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return hashTable[index++].getValue();
	}

	private boolean getIndex() {
		boolean result = false;
		for (int i = index; i < hashTable.length; i++) {
			index = i;
			if (hashTable[i] != null) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		return getIndex();
	}

	private class Node<K, V> {
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.hash = hash();
		}

		public Node(K key) {
			this.key = key;
			this.hash = hash();
		}

		private int hash;
		private K key;
		private V value;

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		private int hash(K key) {
			int hash = 31;
			hash = hash * 17 + key.hashCode() * 11;
			return hash % hashTable.length;
		}

		private int hash() {
			return hash(this.key);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private SimpleHashMap getOuterType() {
			return SimpleHashMap.this;
		}

	}
}
