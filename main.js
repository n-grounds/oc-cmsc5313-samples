
const electron = require('electron');

function createWindow() {
	let win = new electron.BrowserWindow(
		{ width: 800, height: 600 });
	win.loadURL(`file://${__dirname}/index.html`);
}

electron.ipcMain.on('some-call', (args) => {
    console.log(args);
});

electron.app.on('ready', createWindow);
