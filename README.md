<h1>Simple Calculator</h1><br />
<p>A simple Java calculator.</p>
<h2>Description</h2>
<p>This is a simple Calculator built in Java</p>
<p>The Calculations order follows the BODMAS rule</p>
<p>The BODMAS rule has the following order of precedency:</p>
	<ul>
		<li>Brackets () Of</li>
		<li>Division /</li>
		<li>Multiplication *</li>
		<li>Addition +</li>
		<li>Subtraction -</li>
	</ul>
<p>In the BODMAS rule, / and * are on the same level and + and - are also on the same level<br />/ and * take priority over + and -. NOTE that brackets are not part of the application. When entered they will be considered an error</p>
<p>Because of the WindowAdapter, keystrokes are automatically entered into the textfield. NOTE that all characters not represented by the buttons in the User Interface will not be recognised by the application and considered an error in input</p>
<h2>Functionality</h2>
<p>Calculating Simple Equations:</p>
	<ul>
		<li>Division</li>
		<li>Multiplication</li>
		<li>Addition</li>
		<li>Subtraction</li>
	</ul>
<p>The Calculator can accept as long an equation as possible eg: 23*45+33.4/5*77+3454
<h2>Project Structure</h2>
<table>
	<thead>
		<tr>
			<th>Package</th>
			<th>Class</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>main</td>
			<td>Main</td>
			<td>Contains the main method that starts the program. Run this class to begin.</td>
		</tr>
		<tr>
			<td>logic</td>
			<td>Master</td>
			<td>
				<ul>
					<li>An abstract class for application-wide visibility</li>
					<li>Contains all the variables for the GUI and all calculations</li>
					<li>Also contain the methods used in calculations and input error checking methods</li>
				</ul>
			</td>
		</tr>
		<tr>
			<td>gui</td>
			<td>GUI</td>
			<td>
				<ul>
					<li>A public class that builds the Graphical User Interface of the Calculator</li>
					<li>It uses the variables stored in the Master class - which were made global because the MyListener class also needs access to them</li>
				</ul>
			</td>
		</tr>
		<tr>
			<td>listeners</td>
			<td>MyListener</td>
			<td>
				<ul>
					<li>A Class that implements the ActionListener</li>
					<li>It contains one overriden method that listens to fired Action Events of registered objects</li>
				</ul>
			</td>
		</tr>
	</tbody>
</table>
<h2>The Graphical User Interface</h2>
<p>The GUI is built using generic Java Objects from the Swing and AWT super clases. These include:</p>
<ul>
	<li>JFrame</li>
	<li>JPanel</li>
	<li>JTextfield</li>
	<li>JLabel</li>
	<li>JButton</li>
</ul>
<p>The Layout Manager used is from an external Java jar library called <b><em>MigLayout</em></b>. The files are included in the project folder under the sub-folder LIB. When the project is downloaded or cloned, the class path must be updated in the build path by adding 'eternal jars' and removing old locations.</p>
<h3><u>How To Use MigLayout Library:</u></h3>
<ol>
	<li>In Eclipse or STS: Right-click the project name and go to properties</li>
	<li>Under Java Build Path, go to Libraries and delete any associations of the MigLayout jars</li>
	<li>Still in the same location click on ADD EXTERNAL JARS</li>
	<li>Browse to the project folder, into the <b><em>lib</em></b> folder and add all the jars from there</li>
</ol>
<h2>Function Buttons in the GUI</h2>
<ul>
	<li>The <b>OFF</b> button terminates/closes the application</li>
	<li>The <b>CLR</b> button clears the input field</li>
	<li>The <b>BCK</b> button clears the input field character by character beginning from the last added character</li>
	<li>The <b>| = |</b> button starts the process of calculations which begins with error-checking of the input for validity in the context and capabilities of this specific program</li>
	<li>All other buttons input what's written on them into the input field.</li>
</ul>
<h2>Class Details</h2>
<table>
	<thead>
		<tr>
			<th>Class</th>
			<th>Variables</th>
			<th>Methods</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Main</td>
			<td></td>
			<td>main(String):void</td>
		</tr>
		<tr>
			<td>GUI</td>
			<td></td>
			<td>GUI():constructor</td>
		</tr>
		<tr>
			<td>MyListener</td>
			<td></td>
			<td>MyListener():constructor</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<ul>
					<li>mainFrame : JFrame</li>
					<li>container : Container</li>
					<li>mainPanel : JPanel</li>
					<li>displaysPanel : JPanel</li>
					<li>buttonsPanel : JPanel</li>
					<li>inputLabel : JLabel</li>
					<li>outputLabel : JLabel</li>
					<li>inputField : JTextField</li>
					<li>outputField : JTextField</li>
					<li>inputString : String</li>
					<li>outputString : String</li>
					<li>displayString : String</li>
					<li>valueAString : String</li>
					<li>valueBString : String</li>
					<li>resultString : String</li>
					<li>op : String</li>
					<li>tokenString : String</li>
					<li>finalResultString : String</li>
					<li>replacer : String</li>
					<li>initialOp : String</li>
					<li>valueAindex : int</li>
					<li>valueBindex : int</li>
					<li>opIndex : int</li>
					<li>valueA : float</li>
					<li>valueB : float</li>
					<li>result : float</li>
					<li>token : StringTokenizer</li>
					<li>list : List<String></li>
					<li>offB : JButton</li>
					<li>clearB : JButton</li>
					<li>backB : JButton</li>
					<li>multiplyB : JButton</li>
					<li>divideB : JButton</li>
					<li>addB : JButton</li>
					<li>subtractB : JButton</li>
					<li>dotB : JButton</li>
					<li>equalB : JButton</li>
					<li>num0B : JButton</li>
					<li>num1B : JButton</li>
					<li>num2B : JButton</li>
					<li>num3B : JButton</li>
					<li>num4B : JButton</li>
					<li>num5B : JButton</li>
					<li>num6B : JButton</li>
					<li>num7B : JButton</li>
					<li>num8B : JButton</li>
					<li>num9B : JButton</li>
				</ul>
			</td>
			<td>
				<ul>
					<li>isSimpleOp(String):boolean</li>
					<li>simpleOp():void</li>
					<li>complexOp():void</li>
					<li>calculate():void</li>
					<li>isValid():boolean</li>
				</ul>
			</td>
		</tr>
	</tbody>
</table>
<h2>Screenshot</h2>
<img src="https://hpkc.blob.core.windows.net/projects/Simple Calculator/Simple Calculator.jpg" title="Screenshot of the Application" alt="Screenshot of the Application">
