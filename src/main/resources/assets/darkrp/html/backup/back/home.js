class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      page: 0,
      pageName: "Tableau de bord",
      playerName: "Notch",
      gradeName: "Citoyen",
      activeClasses: [false, false, false, false, false, false, false]
    };
    this.handleClick = this.handleClick.bind(this);
    this.test = this.test.bind(this);
    window.home = this;
  }

  componentDidMount() {
    if (window.mcefQuery) {
      window.mcefQuery({
        "request": "username",
        "persistent": false,
        "onSuccess": function (msg) {
          $("#imageID").attr('src', 'https://minotar.net/avatar/' + msg + '/70.png');
          window.home.setState({ playerName: msg });
        },
        "onFailure": function (err, msg) { }
      });
    }
  }

  handleClick(number, name) {
    this.state.activeClasses = new Array(7).fill(false);
    const activeClasses = [...this.state.activeClasses.slice(0, number), !this.state.activeClasses[number], this.state.activeClasses.slice(number + 1)].flat();
    this.setState({ page: number, pageName: name, activeClasses: activeClasses });
  }

  test() {
    console.log("test");
  }

  renderHeader() {
    switch (this.state.page) {
      case 0:
        return <Dashbord />
      case 1:
        return <Command />
      case 2:
        return <Jobs />
      case 3:
        return <Gun />
      case 4:
        return <Entities />
      case 5:
        return <Ammo />
      case 6:
        return <Food />
      default:
        return <Dashbord />
    }
  }


  render() {
    const activeClasses = this.state.activeClasses.slice();
    return (
      <div class="wrapper">
        <div class="d-flex">
          <div class="sidebar bg-f4" id="sidebar-wrapper">
            <div class="border-info">
              <div id="pic" class="sidebar-heading border-bottom">
                <img id="imageID" src="https://minotar.net/avatar/Notch/70.png" />
                <a class="button-job" href="#">{this.state.gradeName} <br /><a class="button-info" href="#">{this.state.playerName}</a></a>
              </div>
            </div>
            <div class="list-group list-group-flush">
              <a className={activeClasses[0] ? "button-f4 active" : "button-f4"} href="#" onClick={() => this.handleClick(0, "Tableau de bord")}><span>Tableau de bord</span></a>
              <a className={activeClasses[1] ? "button-f4 active" : "button-f4"} href="#" onClick={() => this.handleClick(1, "Commandes")}><span>Commandes</span></a>
              <a className={activeClasses[2] ? "button-f4 active" : "button-f4"} href="#" onClick={() => this.handleClick(2, "Metiers")}><span>Metiers</span></a>
              <a className={activeClasses[3] ? "button-f4 active" : "button-f4"} href="#" onClick={() => this.handleClick(3, "Armes")}><span>Armes</span></a>
              <a className={activeClasses[4] ? "button-f4 active" : "button-f4"} href="#" onClick={() => this.handleClick(4, "Entities")}><span>Entities</span></a>
              <a className={activeClasses[5] ? "button-f4 active" : "button-f4"} href="#" onClick={() => this.handleClick(5, "Munitions")}><span>Munitions</span></a>
              <a className={activeClasses[6] ? "button-f4 active" : "button-f4"} href="#" onClick={() => this.handleClick(6, "Nourritures")}><span>Nourritures</span></a>
            </div>
          </div>
          <div id="page-content-wrapper">
            <div class="navbar">
              <img src="jutify.png" width="35" height="35" />
              <a href="#">{this.state.pageName}</a>
            </div>
            <div class="container-fluid">
              {this.renderHeader()}
            </div>
          </div>
        </div>
      </div>
    )
  }
}
