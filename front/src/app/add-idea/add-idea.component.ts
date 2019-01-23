import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IdeaService } from '../idea-service.service';
import { NgForm } from '@angular/forms';
import { Idea } from 'src/app/idea';

@Component({
  selector: 'app-add-idea',
  templateUrl: './add-idea.component.html',
  styleUrls: ['./add-idea.component.css']
})
export class AddIdeaComponent{
  idea: Idea = new Idea();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private ideaService: IdeaService) { }

  gotoList() {
    this.router.navigate(['/ideas']);
  }

  addIdea(): void
  {
    this.ideaService.addIdea(this.idea).subscribe(data => {
      alert("Idea publicada correctamente");
      window.location.replace('/ideas');
    }, error => console.error(error));
  }

  save(form: NgForm) {
    this.ideaService.save(form).subscribe(result => {
      console.log(form);
      this.gotoList();
    }, error => console.error(error));
  }
}
