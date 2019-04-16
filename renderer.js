
const electron = require('electron');

document.getElementById('my-btn')
    .addEventListener('click', () => {
        electron.ipcRenderer.send(
            'some-call',
            document.getElementById('my-text').value);
        // console.log('User clicked button');
    });

