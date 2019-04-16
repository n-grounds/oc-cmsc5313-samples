
const electron = require('electron');

document.getElementById('my-btn')
    .addEventListener('click', () => {
        // electron.ipcRenderer.send(
        //     'some-call', 'User clicked button');
        console.log('User clicked button');
    });

