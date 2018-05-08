<h1>Simple Calculator</h1><br />
<hr />
<h2>Description</h2>
A Simple Calculator built in Java
<h2>Functionality</h2>
<ul>
	<li>Calculating Simple Equations:</li>
	<ul>
		<li>Division</li>
		<li>Multiplication</li>
		<li>Addition</li>
		<li>Subtraction</li>
	</ul>
	<li>The Calculations order follows the BODMAS rule</li>
	<li>The BODMAS rule has the following order of precedency:</li>
	<ul>
		<li>Brackets () Of</li>
		<li>Division /</li>
		<li>Multiplication *</li>
		<li>Addition +</li>
		<li>Subtraction -</li>
	</ul>
	<li>In the BODMAS rule, / and * are on the same level and + and - are also on the same level<br />/ and * take priority over + and -.</li>
	<li>NOTE that brackets are not part of the application. When entered they will be considered an error</li>
	<li>Because of the WindowAdapter, keystrokes are automatically ehtered into the textfield. NOTE that all characters not represented by the buttons in the User Interface will not be recognised by the application and considered an error in input</li>
</ul>
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
			<td>Contains the main method that starts the program. Run this method to begin.</td>
		</tr>
		<tr>
			<td>logic</td>
			<td>Master</td>
			<td>
				<ul>
					<li>An abstract class for application-wide visibility</li>
					<li>Contains all the variables for the GUI and all calculations</li>
					<li>Also contain the methods used in calculations</li>
					<li>Has error checking methods</li>
				</ul>
			</td>
		</tr>
		<tr>
			<td>gui</td>
			<td>GUI</td>
			<td>
				<ul>
					<li>A public class that builds the Graphic User Interface of the Calculator</li>
					<li>It uses the variables stored in the Master class, which were made global because the MyListener class also needs access to them</li>
				</ul>
			</td>
		</tr>
		<tr>
			<td>listeners</td>
			<td>MyListener</td>
			<td>
				<ul>
					<li>A Class that implements the ActionListener</li>
					<li>It contains one overriden methos that listenss to registered Action Events</li>
				</ul>
			</td>
		</tr>
	</tbody>
</table>

