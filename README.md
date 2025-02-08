# ReproductorSound
This project is designed just to help someone. It's a project with Java Swing, the UI is almost horrible, but the important part is the code. The comments are in spanish but it works perfectly.

This project have three classes:
<li><b>SoundReproductor</b></li>
<p>This is the UI class that handler the interactions with the user. Like select the file, play music and stop it.</p>
<li><b>Reproductor</b></li>
<p>This one manage not just the playback of the wav file but also the volume. This class call SliderProgressBar in order to show the duration of the song, like every music reproductor like <i>YouTube Music</i>, <i>Spotify</i> ...</p>
<li><b>SliderProgressBar</b></li>
<p>As I said before, this class is in charge to move the slider to show wich is the actual duration of the file, so extends Thread to avoid blocking the whole application. This class work independently because it's easier to make it move every second until the final than get every time the actual precise duration of the file. To make this possible <i>SoundReproductor</i> change the maximum value of the slider to the total duration of the file.</p>

<hr>
<p>The UI looks like this:</p>
<div align="center">
  <img src="https://github.com/user-attachments/assets/ba822321-f1da-4592-b60e-89db75d847ce" alt="UI of the application" width="40%" height="40%" >
</div><br>
<p>As you can see, the <i>Play</i> and <i>Stop</i> buttons are disabled. This is because just when the file is correct the application allows you to do it.</p>

<p>In addition, the text file change depending on the file. If the file is correct (so it's a wav) the color turns green otherwise it turns red. Like in the following example:</p>
<div align="center">
  <img src="https://github.com/user-attachments/assets/c820992f-dd3c-40f7-b8af-068b459c980d" alt="Wrong file selected" width="40%" height="40%">
  <img src="https://github.com/user-attachments/assets/912c6bb8-1bc4-4ebf-bac0-041b041c5e2b" alt="Correct file selected" width="40%" height="40%">
</div>


