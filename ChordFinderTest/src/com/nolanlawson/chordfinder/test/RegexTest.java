package com.nolanlawson.chordfinder.test;

import android.test.ActivityInstrumentationTestCase2;

import com.nolanlawson.chordfinder.FindChordsActivity;
import com.nolanlawson.chordfinder.chords.Chord;
import com.nolanlawson.chordfinder.chords.regex.ChordParser;
import static com.nolanlawson.chordfinder.chords.ChordRoot.*;
import static com.nolanlawson.chordfinder.chords.ChordAdded.*;
import static com.nolanlawson.chordfinder.chords.ChordSuspended.*;
import static com.nolanlawson.chordfinder.chords.ChordQuality.*;
import static com.nolanlawson.chordfinder.chords.ChordSeventh.*;

public class RegexTest extends
		ActivityInstrumentationTestCase2<FindChordsActivity> {

	public RegexTest() {
		super("com.nolanlawson.chordfinder", FindChordsActivity.class);
	}

	public void test1() {
		testRegex("Cmaj7", Chord.newChord(C, Major, Major7, null, null, null));
		testRegex("C#maj7", Chord.newChord(Db, Major, Major7, null, null, null));
		testRegex("Amaj7", Chord.newChord(A, Major, Major7, null, null, null));
		testRegex("A#maj7", Chord.newChord(Bb, Major, Major7, null, null, null));
		testRegex("Dmaj7", Chord.newChord(D, Major, Major7, null, null, null));
		testRegex("Gmaj7", Chord.newChord(G, Major, Major7, null, null, null));

	}
	
	public void test2() {
		testRegex("Gadd9", Chord.newChord(G, Major, null, Add9, null, null));
		testRegex("Gadd11", Chord.newChord(G, Major, null, Add11, null, null));
		testRegex("Abadd9", Chord.newChord(Ab, Major, null, Add9, null, null));
		testRegex("Abminadd9", Chord.newChord(Ab, Minor, null, Add9, null, null));
		

		
	}
	
	public void test3() {
		testRegex("Gsus4", Chord.newChord(G, Major, null, null, Sus4, null));
		testRegex("G#sus", Chord.newChord(Ab, Major, null, null, Sus4, null));
		testRegex("Absus2", Chord.newChord(Ab, Major, null, null, Sus2, null));
		testRegex("Asus4", Chord.newChord(A, Major, null, null, Sus4, null));

	}	
	
	public void test4() {
		testRegex("G/F", Chord.newChord(G, Major, null, null, null, F));
		testRegex("G#/Bb", Chord.newChord(Ab, Major, null, null, null, Bb));
		testRegex("C/D", Chord.newChord(C, Major, null, null, null, D));
	}
	
	public void test5() {
		testRegex("C7", Chord.newChord(C, Major, Dominant7, null, null, null));
		testRegex("D#7", Chord.newChord(Eb, Major, Dominant7, null, null, null));
		testRegex("D#maj7", Chord.newChord(Eb, Major, Major7, null, null, null));
		testRegex("D#m7", Chord.newChord(Eb, Minor, Minor7, null, null, null));
		testRegex("D#min7", Chord.newChord(Eb, Minor, Minor7, null, null, null));
		testRegex("D#M7", Chord.newChord(Eb, Major, Major7, null, null, null));
	}
	
	public void test6() {
		testRegex("C", Chord.newChord(C, Major, null, null, null, null));
		testRegex("CM", Chord.newChord(C, Major, null, null, null, null));
		testRegex("Cm", Chord.newChord(C, Minor, null, null, null, null));
		
	}
	
	public void testRegex(String chordString, Chord expected) {
		
		Chord chord = ChordParser.parseChord(chordString);
		
		assertEquals(expected, chord);

	}
}
