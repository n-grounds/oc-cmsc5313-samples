
const electron = require('electron');

document.getElementById('my-btn')
    .addEventListener('click', () => {
        // electron.ipcRenderer.send(
        //     'some-call',
        //     document.getElementById('my-text').value);
        // console.log('User clicked button');
        const v = document.getElementById('my-text').value;
        const div = document.getElementById('content');
        //add new HTML element to div with the my-text value
        //as it's content
        const span = document.createElement('span');
        span.appendChild(document.createTextNode( v ));
        div.appendChild(span);
        document.getElementById('my-text').value = '';
    });

