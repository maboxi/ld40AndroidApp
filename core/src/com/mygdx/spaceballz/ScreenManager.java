package com.mygdx.spaceballz;

import java.util.EmptyStackException;
import java.util.Stack;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class ScreenManager {

	private final Stack<Screen> stack;
	private final Game game;
	
	public ScreenManager(final Game game) {
		stack = new Stack<Screen>();
		this.game = game;
	}
	
	public void push(Screen s) {
		stack.push(s);
		game.setScreen(s);
	}
	
	public void pop() {
		try {
			stack.pop();
			game.setScreen(stack.peek());
		} catch (EmptyStackException e) {
			e.printStackTrace();
			Gdx.app.exit();
		}
	}
	
	public void set(Screen s) {
		try {
			stack.pop();
		} catch (EmptyStackException e) {
			e.printStackTrace();
			Gdx.app.exit();
		}
		stack.push(s);
		game.setScreen(s);
	}
	
	public Screen get() {
		try {
			return stack.peek();
		} catch (EmptyStackException e) {
			e.printStackTrace();
			Gdx.app.exit();
		}
		return null;
	}
	
	public void dispose() {
		game.setScreen(null);
		for(Screen s : stack) {
			s.dispose();
		}
		stack.clear();
	}
}
